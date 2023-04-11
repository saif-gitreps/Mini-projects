from random import shuffle

name_list = ['who', 'is', 'ya', 'idk', 'no',
             'yes', 'oky', 'cent', "s", 'doe', " ", 'perhaps', 'nah', '.ik', '.who', '.is', '.ya', '.idk', '.k', '.no',
             '.yes', '.oky', '.cent', ".s", '.doe', " ", '.perhaps', '.nah']

name_list2 = ["shes.", 's.', 'ash.', " ", 'who.', 'yes.']
num_list = ['8', '7', 'p', '3', '5', '1']
name = "aysha"
for i in range(1, 25):
    shuffle(name_list2)
    name1 = name_list2[0]
    shuffle(name_list)
    name2 = name_list[0]
    shuffle(num_list)
    print(name1 + name[0] + name[1:] + name2)
