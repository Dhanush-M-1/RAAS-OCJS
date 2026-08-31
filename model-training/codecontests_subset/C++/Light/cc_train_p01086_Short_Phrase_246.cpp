#include<iostream>
#include<string>
using namespace std;
typedef long long ll;
#define REP(i,n) for(ll i=0;i<n;i++)
int main(){
while(1){
ll n;
cin >>n;
if(n==0){
break;
}
string name[n];
REP(i,n){
cin>>name[i];
}
ll num[n];
REP(i,n){
num[i]=name[i].length();
}

REP(i,n){
ll len=0;
ll now=i;
while(len<5){
len+=num[now];
now++;
}

if(len==5){
len=0;
while(len<7){
len+=num[now];
now++;
}
if(len==7){
len=0;
while(len<5){
len+=num[now];
now++;
}
if(len==5){
len=0;
while(len<7){
len+=num[now];
now++;
}
if(len==7){
len=0;
while(len<7){
len+=num[now];
now++;
}
if(len==7){
cout<<i+1<<endl;
break;
}
}
}

}
}

}





}


return 0;
}
