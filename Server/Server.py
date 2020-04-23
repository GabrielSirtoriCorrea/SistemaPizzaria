import socketserver
from datetime import datetime
import json, time, os, DataBaseConnection

print("=-=-=-=-=-=-=-=-=-=-=-=-=-=--=Servidor iniciado-=-=-=-=-=-=-=-=-=--=-=-=-=-=")

'''jsonTest = {
        'ID': 'Testando',
        'client': 'banco',
        'phone': 'de',
        'address': 'dados',
        'pizzaType': 'no',
        'pizzaBorder': 'novo',
        'pizzaQntdTastes': 1,
        'pizzaTaste1': 'sistema',
        'pizzaTaste2': 'do',
        'comments': 'gazebo',
        'totalPrice': 1,
        'status': 'boladao'}'''

#myHost = '192.168.0.113'
myHost = '192.168.0.5'
myPort = 3000

class ClientManage(socketserver.BaseRequestHandler):
    def handle(self):

        hora = datetime.now()
        print(f'Conectado por: {self.client_address} as {hora.hour}:{hora.minute}')

        data = self.request.recv(1024).decode('utf-8')
        print(data)
  
        if True:
            data = json.loads(data)

            if data['ID'] == 'AppSendNewRequest':
                DataBase = DataBaseConnection.DataBaseConnection()
                DataBase.InsertNewRequest(json.dumps(data))
                print(DataBase.getAllRequests())
                    
            elif data['ID'] == 'DesktopFinishRequest':
                DataBase = DataBaseConnection.DataBaseConnection()
                DataBase.setFinishRequest(data['client'])
                print(DataBase.getAllRequests())

            elif data['ID'] == 'DesktopGetAllRequests':
                DataBase = DataBaseConnection.DataBaseConnection()
                self.request.send(json.dumps(DataBase.getAllRequests()).encode())
    

adress = (myHost, myPort)
server = socketserver.ThreadingTCPServer(adress, ClientManage)
server.serve_forever()
