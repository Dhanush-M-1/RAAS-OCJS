#include <bits/stdc++.h>

using namespace std;


int main(int argc, char **argv) {
    int N;
    cin>>N;
    map<string,int> m;
    for(int c=0;c<N;c++) {
        string s;
        cin>>s;
        m[s]++;
    }
    cout<<"AC x "<<m["AC"]<<"\nWA x "<<m["WA"]<<"\nTLE x "<<m["TLE"]<<"\nRE x "<<m["RE"];
}
