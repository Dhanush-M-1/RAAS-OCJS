#include <bits/stdc++.h>
using namespace std;

void f(int ct, string s, int n) {
  if (ct == 0) {
    cout << s << endl;
    return;
  }
  for(int i=0; i<n+2; i++){
    string tmp=s;
    tmp.push_back('a'+i);
    f(ct-1, tmp, max(n, i));
  }
}

int main() {
  int n;
  cin >> n;
  f(n - 1, "a", 0);
  return 0;
}
