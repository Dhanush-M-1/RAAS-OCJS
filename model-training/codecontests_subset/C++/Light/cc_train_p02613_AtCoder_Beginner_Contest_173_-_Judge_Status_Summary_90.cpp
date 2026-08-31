#include<iostream>
#include<unordered_map>
using namespace std;
int n;
unordered_map<string,int>m;
string s,k[4]={"AC","WA","TLE","RE"};
int main(){
    cin>>n;
    while(n--){
        cin>>s;
        m[s]++;
    }
    for(n=0;n<4;n++){
        cout<<k[n]<<" x "<<m[k[n]]<<"\n";
    }
}
