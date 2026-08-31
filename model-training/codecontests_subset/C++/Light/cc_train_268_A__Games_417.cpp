#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int* home = new int[n];
  int* away = new int[n];
  for (int i = 0; i < n; i++) {
    cin >> home[i];
    cin >> away[i];
  }
  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (away[j] == home[i]) {
        count++;
      }
    }
  }
  cout << count << endl;
}
