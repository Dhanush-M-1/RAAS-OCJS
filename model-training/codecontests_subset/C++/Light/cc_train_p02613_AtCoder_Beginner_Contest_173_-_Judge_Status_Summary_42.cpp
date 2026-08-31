#include<bits/stdc++.h>
using namespace std;

int main() {
    int N; cin >> N;
    map<string, int> mp;
    for (int i = 0; i < N; i++) {
        string S; cin >> S;
        mp[S]++;
    }

    for (auto e: {"AC", "WA", "TLE", "RE"}) {
        cout << e << " x " << mp[e] << endl;
    }
}