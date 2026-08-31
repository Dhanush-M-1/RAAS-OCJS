#include <bits/stdc++.h>
using namespace std;
int n;
int n1, n2;
int grau[100010];
vector<pair<int, int> > edges;
int main() {
  scanf("%d", &n);
  for (int g = 0; g < n - 1; g++) {
    scanf("%d %d", &n1, &n2);
    grau[n1]++;
    grau[n2]++;
  }
  for (int g = 1; g <= n; g++) {
    if (grau[g] == 2) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
}
