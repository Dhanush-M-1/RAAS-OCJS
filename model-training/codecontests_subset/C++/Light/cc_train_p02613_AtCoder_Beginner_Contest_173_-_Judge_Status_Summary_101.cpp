#include<bits/stdc++.h>
 
using namespace std;
 
 
int main() {
	int t;
  	cin >> t;
  map<string, int> cnt;
  while(t--) {
   string s;
    cin >> s;
    cnt[s]++;
  }
  
  string x[] = {"AC", "WA", "TLE", "RE"};
  
  for(int i = 0; i < 4; i++) {
   cout << x[i] << " x " << cnt[x[i]] << "\n";
  }
  
}
