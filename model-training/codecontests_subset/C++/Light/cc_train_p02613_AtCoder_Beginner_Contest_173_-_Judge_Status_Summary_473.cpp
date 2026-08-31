#include <bits/stdc++.h>
using namespace std;
 
int main(){
    int N;
    cin >> N;
    map<string, int> mp;
    while(N--){
        string s;
        cin >> s;
        mp[s]++;
    }
    for(string s : {"AC", "WA", "TLE", "RE"}) cout << s << " x " << mp[s] << endl;
    return 0;
}