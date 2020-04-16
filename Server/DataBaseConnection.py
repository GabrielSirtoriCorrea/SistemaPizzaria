import sqlite3, json

class DataBaseConnection:
    def __init__(self):
        DataBasePath = 'C:\\Users\\Gazebo\\Documents\\Projetos Github\\SistemaPizzaria\\Server\\PizzeriaDataBase.db'

        self.DataBase = sqlite3.connect(DataBasePath)

        self.DataBaseCursor = self.DataBase.cursor()

        self.DataBaseCursor.execute('CREATE TABLE IF NOT EXISTS Request(client TEXT, phone TEXT, address TEXT,'
                                                                        'pizzaType TEXT, pizzaBorder TEXT, pizzaQntdTastes INTEGER,'
                                                                        'pizzaTaste1 TEXT, pizzaTaste2 TEXT, comments TEXT,'
                                                                        'totalPrice INTEGER, status TEXT)') 

        self.DataBase.commit()

    def InsertNewRequest(self, JSON):
        NewRequest = json.loads(JSON)

        self.DataBaseCursor.execute('INSERT INTO Request (client, phone, address, pizzaType, pizzaBorder, pizzaQntdTastes,'
                                    'pizzaTaste1, pizzaTaste2, comments, totalPrice, status)'
                                    'VALUES (?,?,?,?,?,?,?,?,?,?,?)', (NewRequest['client'], NewRequest['phone'], NewRequest['address'],
                                    NewRequest['pizzaType'], NewRequest['pizzaBorder'], int(NewRequest['pizzaQntdTastes']), NewRequest['pizzaTaste1'], NewRequest['pizzaTaste2'],
                                    NewRequest['comments'], int(NewRequest['totalPrice']), 'EM ANDAMENTO'))

        self.DataBase.commit()

    def getAllRequests(self):
        self.DataBaseCursor.execute('SELECT * from Request')
        return self.DataBaseCursor.fetchall()


    def setFinishRequest(self, client):
        self.DataBaseCursor.execute('UPDATE Request SET status = ? WHERE client = ?', ('Concluido', client))
        self.DataBase.commit()