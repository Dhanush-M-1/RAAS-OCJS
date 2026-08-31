#include <bits/stdc++.h>
using namespace std;
string table[12][12];
int k;
int main() {
  scanf("%d", &k);
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++) {
      int val = i * j;
      string s;
      while (val) {
        s += (val % k) + '0';
        val /= k;
      }
      reverse(s.begin(), s.end());
      table[i][j] = s;
    }
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << table[i][j];
      if (j == k - 1)
        printf("\n");
      else
        printf(" ");
    }
  }
}
