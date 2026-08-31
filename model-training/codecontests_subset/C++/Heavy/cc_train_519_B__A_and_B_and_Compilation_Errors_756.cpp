#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, errorcode;
  cin >> n;
  map<int, int> set1;
  map<int, int> set2;
  map<int, int>::iterator it;
  for (i = 0; i < n; i++) {
    cin >> errorcode;
    if (set1.count(errorcode)) {
      set1[errorcode]++;
    } else {
      set1[errorcode] = 1;
    }
  }
  for (i = 0; i < (n - 1); i++) {
    cin >> errorcode;
    set1[errorcode]--;
    if (set2.count(errorcode)) {
      set2[errorcode]++;
    } else {
      set2[errorcode] = 1;
    }
  }
  for (it = set1.begin(); it != set1.end(); it++) {
    if (it->second == 1) {
      cout << it->first << endl;
    }
  }
  for (i = 0; i < (n - 2); i++) {
    cin >> errorcode;
    set2[errorcode]--;
  }
  for (it = set2.begin(); it != set2.end(); it++) {
    if (it->second == 1) {
      cout << it->first << endl;
    }
  }
  return 0;
}
