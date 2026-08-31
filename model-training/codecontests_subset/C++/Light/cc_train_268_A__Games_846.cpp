#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int c1, c2;
  int count = 0;
  int* primary_color = new int[n];
  int* secondary_color = new int[n];
  for (int i = 0; i < n; i++) {
    cin >> primary_color[i] >> secondary_color[i];
  }
  int j = 0;
  while (j < n) {
    for (int i = 0; i < n; i++) {
      if (primary_color[j] == secondary_color[i]) {
        count++;
      }
    }
    j++;
  }
  cout << count << endl;
}
