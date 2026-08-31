#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int **teams = new int *[n];
  for (int i = 0; i < n; teams[i] = new int[2], i++)
    ;
  for (int i = 0; i < n; cin >> teams[i][0] >> teams[i][1], i++)
    ;
  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (teams[i][0] == teams[j][1]) count++;
      if (teams[i][1] == teams[j][0]) count++;
    }
  }
  cout << count;
}
