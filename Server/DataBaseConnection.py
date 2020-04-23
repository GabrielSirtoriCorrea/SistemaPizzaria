import sqlite3, json

class DataBaseConnection:
    def __init__(self):
        DataBasePath = 'C:\\Users\\Gazebo\\Documents\\ProjetosGithub\\SistemaPizzaria\\Server\\PizzeriaDataBase.db'

        self.DataBase = sqlite3.connect(DataBasePath)

        self.DataBaseCursor = self.DataBase.cursor()

        self.DataBaseCursor.execute('CREATE TABLE IF NOT EXISTS Request(client TEXT, phone TEXT, address TEXT,'
                                                                        'pizzaType TEXT, pizzaQntdTastes INTEGER,'
                                                                        'pizzaTaste1 TEXT, comments TEXT,'
                                                                        'totalPrice INTEGER, status TEXT)') 

        self.DataBase.commit()

    def InsertNewRequest(self, JSON):
        NewRequest = json.loads(JSON)

        self.DataBaseCursor.execute('INSERT INTO Request (client, phone, address, pizzaType, pizzaQntdTastes,'
                                    'pizzaTaste1, comments, totalPrice, status)'
                                    'VALUES (?,?,?,?,?,?,?,?,?)', (NewRequest['client'], NewRequest['phone'], NewRequest['address'],
                                    NewRequest['pizzaType'], int(NewRequest['pizzaQntdTastes']), NewRequest['pizzaTaste1'],
                                    NewRequest['comments'], int(NewRequest['totalPrice']), 'EM ANDAMENTO'))

        self.DataBase.commit()

    def getAllRequests(self):
        self.DataBaseCursor.execute('SELECT * from Request')
        Requests = self.DataBaseCursor.fetchall()

        jsonResponse = {
        'client': Requests[0][0],
        'phone': Requests[0][1],
        'address': Requests[0][2],
        'pizzaType': Requests[0][3],
        'pizzaQntdTastes': Requests[0][4],
        'pizzaTaste1': Requests[0][5],
        'comments': "null",
        'totalPrice': Requests[0][7],
        'status': Requests[0][8]}

        return jsonResponse


    def setFinishRequest(self, client):
        self.DataBaseCursor.execute('UPDATE Request SET status = ? WHERE client = ?', ('Concluido', client))
        self.DataBase.commit()