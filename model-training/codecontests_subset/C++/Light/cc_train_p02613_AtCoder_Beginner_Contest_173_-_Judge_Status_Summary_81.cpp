#include<iostream>
#include<string>
#include<map>
using namespace std;

int main() {
    int n; scanf("%d",&n);
    map<string, int> mp;
    while(n--){
        string s; cin >> s;
        mp[s]++;
    }  
    printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d", mp["AC"], mp["WA"], mp["TLE"], mp["RE"]);
    return 0;
}