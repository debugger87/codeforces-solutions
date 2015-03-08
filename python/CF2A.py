aDict={}
bArray=[]
num=int(raw_input())
for i in xrange(num):
    name,score = raw_input().split()
    score = int(score)
    if name in aDict.keys():
        aDict[name]+=score
    else:
        aDict[name]=score
    bArray.append((name,aDict[name]))

maxscore = max(aDict.values())

for name,score in bArray:
    if score>=maxscore and aDict[name]==maxscore:
        print name
        break
