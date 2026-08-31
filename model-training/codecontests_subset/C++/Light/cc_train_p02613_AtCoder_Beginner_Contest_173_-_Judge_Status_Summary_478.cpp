#include<bits/stdc++.h>
using namespace std;

int n;

int main(void){
    cin >> n;
    unordered_map<string, int> m;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        m[s]++;
    }
    printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n", m["AC"], m["WA"], m["TLE"], m["RE"]);
    return 0;
}
