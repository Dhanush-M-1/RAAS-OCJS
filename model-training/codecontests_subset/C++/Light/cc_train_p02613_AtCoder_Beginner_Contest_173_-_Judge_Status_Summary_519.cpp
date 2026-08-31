#include <bits/stdc++.h>
using namespace std;

int main() {
   int N;
   cin >> N;
   map<string, int> ans;
   for(int i=0;i<N;i++) {
       string s;
       cin >> s;
       ans[s]++;
   }
   for (string s: {"AC", "WA", "TLE", "RE"}) {
       cout << s << " x " << ans[s] << endl;
   }
}