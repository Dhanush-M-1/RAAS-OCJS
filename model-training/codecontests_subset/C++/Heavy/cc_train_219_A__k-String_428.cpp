#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  vector<char> b;
  cin >> k;
  string a;
  cin >> a;
  int s = 0;
  string p = "";
  for (int i = 0; i < a.size(); i++) {
    if (b.size() != 0) {
      for (int j = 0; j < b.size(); j++) {
        if (a[i] == b[j]) s = 1;
      }
    }
    if (s == 0) b.push_back(a[i]);
    s = 0;
  }
  int h[b.size()];
  int count = 0;
  for (int i = 0; i < b.size(); i++) {
    for (int j = 0; j < a.size(); j++) {
      if (b[i] == a[j]) count++;
    }
    h[i] = count;
    count = 0;
  }
  for (int i = 0; i < b.size(); i++) {
    if (h[i] % k != 0) {
      cout << "-1" << endl;
      return 0;
    }
  }
  for (int i = 0; i < b.size(); i++) {
    for (int j = 0; j < h[i] / k; j++) p = p + b[i];
  }
  for (int i = 0; i < k; i++) cout << p;
  cout << endl;
  return 0;
}
