#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    map<string, int> ma;
    string s;
    for(int i=0; i<n; i++) {
        cin >> s;
        ma[s]++;
    }
    for(auto ss: {"AC", "WA", "TLE", "RE"}) cout << ss << " x " << ma[ss] << endl;
    return 0;
}