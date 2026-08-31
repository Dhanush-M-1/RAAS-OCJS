#include<bits/stdc++.h>
using namespace std;
#define ll long long
int  main(){
    int n;
    map<string,int> m;
    string x;
    cin>> n;
    for(int i =0; i<n; i++){
        cin>>x;
        m[x]++;
    }
    cout<<"AC x "<<m["AC"]<<"\nWA x "<<m["WA"]<<"\nTLE x "<<m["TLE"]<<"\nRE x "<<m["RE"];
    return 0;
}
