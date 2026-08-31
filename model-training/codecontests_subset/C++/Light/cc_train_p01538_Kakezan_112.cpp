#include <bits/stdc++.h>
using namespace std;

int main() {
  int Q; cin >> Q;
  while(Q--) {
    int N; cin >> N;
    int res = 0;
    set<int> s;
    while(N >= 10) {
      string n;
      {
        stringstream ss; ss << N;
        n = ss.str();
      }
      int maxi = -1;
      for(int i = 1; i < n.size(); ++i) {
        string a = n.substr(0, i);
        string b = n.substr(i);
        int x = atoi(a.c_str()) * atoi(b.c_str());
        maxi = max(maxi, x);
      }
      N = maxi;
      if(s.count(N)) {
        res = -1; break;
      }
      s.insert(N);
      ++res;
    }
    cout << res << endl;
  }
  return 0;
}