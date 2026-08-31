#include <bits/stdc++.h>

using namespace std;
map<string, int> mp;
int N;

int main(){
    cin>>N;
    while (N--){
        string s;
        cin>>s;
        mp[s]++;
    }
    cout<<"AC x "<<mp["AC"]<<endl;
    cout<<"WA x "<<mp["WA"]<<endl;
    cout<<"TLE x "<<mp["TLE"]<<endl;
    cout<<"RE x "<<mp["RE"]<<endl;
}