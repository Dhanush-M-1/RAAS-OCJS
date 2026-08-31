#include <bits/stdc++.h>

using namespace std;

int main(){
int n=0;
string str="";
map<string ,int>mp;
cin>>n;
while(n--){
cin>>str;
mp[str]++;
}
cout<<"AC x "<<mp["AC"]<<"\n";
cout<<"WA x "<<mp["WA"]<<"\n";
cout<<"TLE x "<<mp["TLE"]<<"\n";
cout<<"RE x "<<mp["RE"]<<"\n";





    return 0;
}
