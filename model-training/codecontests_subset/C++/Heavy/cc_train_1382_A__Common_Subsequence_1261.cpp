#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, k, x;
  cin >> t;
  vector<int> vec1;
  vector<int> vec2;
  vector<int>::iterator it, it2;
  for (int i = 0; i < t; i++) {
    int a, b;
    cin >> a >> b;
    for (int j = 0; j < a; j++) {
      cin >> k;
      vec1.push_back(k);
    }
    for (int l = 0; l < b; l++) {
      cin >> k;
      vec2.push_back(k);
    }
    stack<int> s;
    x = 0;
    for (it = vec1.begin(); it != vec1.end(); it++) {
      for (it2 = vec2.begin(); it2 != vec2.end(); it2++) {
        if (*it == *it2) {
          s.push(*it2);
          x++;
        }
      }
    }
    if (x == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << "1"
           << "\t" << s.top() << endl;
    }
    while (x--) {
      s.pop();
    }
    vec1.clear();
    vec2.clear();
  }
}
