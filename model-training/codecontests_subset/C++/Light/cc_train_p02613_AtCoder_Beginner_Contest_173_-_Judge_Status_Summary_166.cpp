#include<bits/stdc++.h>
using namespace std;
int main(){
    map<string,int>ans;
    int n;
    cin>>n;
    while(n--){
        string s;
        cin>>s;
        ans[s]++;
    }
    cout<<"AC x "<<ans["AC"]<<endl;
    cout<<"WA x "<<ans["WA"]<<endl;
    cout<<"TLE x "<<ans["TLE"]<<endl;
    cout<<"RE x "<<ans["RE"]<<endl;
}
