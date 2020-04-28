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

    def getAllPendingRequests(self):
        self.DataBaseCursor.execute("SELECT * from Request WHERE status=?", ('EM ANDAMENTO',))
        Requests = self.DataBaseCursor.fetchall()
        ListRequestsIDs = list()
        ListRequests = list()
        ListRequestData = ['client', 'phone', 'address', 'pizzaType', 'pizzaQntdTastes', 'pizzaTaste1', 'comments', 'totalPrice', 'status']
        cont = 0

        for Request in Requests:
            cont+=1
            ListRequestsIDs.append(str(cont))

            ListRequests.append(dict(zip(ListRequestData, Request)))
            '''DictResponse += {
            'client': Requests[Request][0],
            'phone': Requests[Request][1],
            'address': Requests[Request][2],
            'pizzaType': Requests[Request][3],
            'pizzaQntdTastes': Requests[Request][4],
            'pizzaTaste1': Requests[Request][5],
            'comments': Requests[Request][6],
            'totalPrice': Requests[Request][7],
            'status': Requests[Request][8]}'''


        DictResponse = dict(zip(ListRequestsIDs, ListRequests))

        print(DictResponse)

        return DictResponse


    def setFinishRequest(self, phone):
        self.DataBaseCursor.execute('UPDATE Request SET status = ? WHERE phone = ?', ('Concluido', phone))
        self.DataBase.commit()

    def getAllRequests(self):
        self.DataBaseCursor.execute("SELECT * from Request WHERE status=?", ('Concluido',))
        Requests = self.DataBaseCursor.fetchall()
        ListRequestsIDs = list()
        ListRequests = list()
        ListRequestData = ['client', 'phone', 'address', 'pizzaType', 'pizzaQntdTastes', 'pizzaTaste1', 'comments', 'totalPrice', 'status']
        cont = 0

        for Request in Requests:
            cont+=1
            ListRequestsIDs.append(str(cont))

            ListRequests.append(dict(zip(ListRequestData, Request)))
            '''DictResponse += {
            'client': Requests[Request][0],
            'phone': Requests[Request][1],
            'address': Requests[Request][2],
            'pizzaType': Requests[Request][3],
            'pizzaQntdTastes': Requests[Request][4],
            'pizzaTaste1': Requests[Request][5],
            'comments': Requests[Request][6],
            'totalPrice': Requests[Request][7],
            'status': Requests[Request][8]}'''


        DictResponse = dict(zip(ListRequestsIDs, ListRequests))

        print(DictResponse)

        return DictResponse