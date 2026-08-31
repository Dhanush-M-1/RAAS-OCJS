#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    string s;
    unordered_map<string,int> m;
    for(int i=0;i<n;i++){cin>>s;m[s]++;}
    cout<<"AC x "<<m["AC"]<<"\n";
    cout<<"WA x "<<m["WA"]<<"\n";
    cout<<"TLE x "<<m["TLE"]<<"\n";
    cout<<"RE x "<<m["RE"]<<"\n";
    
}