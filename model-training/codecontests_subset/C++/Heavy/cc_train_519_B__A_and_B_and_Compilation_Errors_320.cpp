#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);
  long long n;
  cin >> n;
  map<int, int> mp1;
  map<int, int> mp2;
  map<int, int> mp3;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    mp1[x]++;
  }
  for (long long i = 0; i < n - 1; i++) {
    long long x;
    cin >> x;
    mp2[x]++;
    if (mp1[x]) {
      mp1[x]--;
      if (mp1[x] <= 0) {
        mp1.erase(x);
      }
    }
  }
  for (long long i = 0; i < n - 2; i++) {
    long long x;
    cin >> x;
    mp3[x]++;
    if (mp2[x]) {
      mp2[x]--;
      if (mp2[x] <= 0) {
        mp2.erase(x);
      }
    }
  }
  auto it = mp1.begin();
  cout << it->first << endl;
  it = mp2.begin();
  cout << it->first << endl;
}
