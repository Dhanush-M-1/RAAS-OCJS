#include <bits/stdc++.h>
using namespace std;
map<int, int> mp1, mp2, mp3;
int a[100005], b[100005], c[100005];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mp1[a[i]]++;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> b[i];
    mp2[b[i]]++;
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> c[i];
    mp3[c[i]]++;
  }
  for (int i = 0; i < n; i++) {
    if (mp1[a[i]] > mp2[a[i]]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (mp2[b[i]] > mp3[b[i]]) {
      cout << b[i] << endl;
      break;
    }
  }
}
