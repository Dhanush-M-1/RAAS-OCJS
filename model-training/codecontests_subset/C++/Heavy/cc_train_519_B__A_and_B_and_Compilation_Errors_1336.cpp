#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  cin >> n;
  int arr[n + 1];
  map<int, int> mp1, mp2;
  for (int i = 0; i < n; i++) {
    cin >> x;
    mp1[x]++;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    mp2[x]++;
  }
  for (auto itr = mp1.begin(); itr != mp1.end(); itr++) {
    int a = itr->first;
    if (mp1[a] - mp2[a] > 0) {
      cout << a << endl;
      mp2[a]++;
      mp1[a]--;
    } else
      continue;
  }
  mp2.clear();
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    mp2[x]++;
  }
  for (auto itr = mp1.begin(); itr != mp1.end(); itr++) {
    int a = itr->first;
    if (mp1[a] - mp2[a] > 0) {
      cout << a << endl;
    } else
      continue;
  }
}
