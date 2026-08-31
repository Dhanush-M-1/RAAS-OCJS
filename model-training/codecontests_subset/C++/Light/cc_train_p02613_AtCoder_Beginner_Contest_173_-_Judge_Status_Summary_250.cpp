#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;cin>>n;
    map<string, int>mp;
    string s;
    for(int i=0;i<n;++i){
        cin>>s;
        mp[s]++;
    }
    cout<<"AC x "<<mp["AC"]<<endl;
    cout<<"WA x "<<mp["WA"]<<endl;
    cout<<"TLE x "<<mp["TLE"]<<endl;
    cout<<"RE x "<<mp["RE"]<<endl;
}