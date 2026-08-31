#include <bits/stdc++.h>

#define REP(i,n) for(int i=0;i<(int)n;++i)

using namespace std;

bool is_57577(const vector<int> &l, int i) {
  deque<int> phrases = {5, 7, 5, 7, 7};
  for (int j = i; j < l.size(); ++j) {
    phrases[0] -= l[j];
    if (phrases[0] < 0) return false;
    if (phrases[0] == 0) {
      phrases.pop_front();
      if (phrases.empty()) return true;
    }
  }
  return false;
}

int main() {
  while(1){
    int n;
    cin>>n;
    if(!n)break;
    vector<int> l(n);
    REP(i,n){
      string s;
      cin>>s;
      l[i] = s.size();
    }
    REP(i,n) {
      if(is_57577(l, i)) {
        cout << (i+1) << endl;
        break;
      }
    }
  }
  return 0;
}