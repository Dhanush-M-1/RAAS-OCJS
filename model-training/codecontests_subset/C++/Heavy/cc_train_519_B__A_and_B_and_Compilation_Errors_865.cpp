#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> a, b, c;
  int n;
  int arr[10001];
  cin >> n;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    a.push_back(temp);
  }
  sort(a.begin(), a.end());
  int first = 0, second = 0;
  for (int i = 0; i < n - 1; i++) {
    int temp;
    cin >> temp;
    b.push_back(temp);
  }
  sort(b.begin(), b.end());
  for (int i = 0; i < n - 2; i++) {
    int temp;
    cin >> temp;
    c.push_back(temp);
  }
  sort(c.begin(), c.end());
  bool isfound = false;
  for (int i = a.size() - 1; i >= 0; i--) {
    if (i == 0 && !isfound)
      first = a[i];
    else if (!isfound) {
      if (a[i] != b[i - 1]) {
        first = a[i];
        isfound = true;
      }
    }
  }
  isfound = false;
  for (int i = b.size() - 1; i >= 0; i--) {
    if (i == 0 && !isfound)
      second = b[i];
    else if (!isfound) {
      if (b[i] != c[i - 1]) {
        second = b[i];
        isfound = true;
      }
    }
  }
  cout << first << endl << second << endl;
  return 0;
}
