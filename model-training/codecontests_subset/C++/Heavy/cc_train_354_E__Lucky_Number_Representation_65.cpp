#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > options[10];
vector<int> res[6];
bool go(long long target) {
  if (target <= 0) return (target == 0);
  int digit = target % 10;
  for (int i = 0; i < options[digit].size(); i++) {
    pair<int, int> option = options[digit][i];
    int remains = (option.first * 4 + option.second * 7) / 10;
    if (!go(target / 10 - remains)) continue;
    for (int j = 0; j < option.first; j++) res[j].push_back(4);
    for (int j = option.first; j < option.first + option.second; j++)
      res[j].push_back(7);
    for (int j = option.first + option.second; j < 6; j++) res[j].push_back(0);
    return 1;
  }
  return 0;
}
void print(vector<int>& t) {
  int start = 0;
  while ((start < t.size() - 1) and (t[start] == 0)) start++;
  for (int i = start; i < t.size(); i++) printf("%d", t[i]);
  printf(" ");
}
int main() {
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j <= 6 - i; j++)
      options[(i * 4 + j * 7) % 10].push_back(make_pair(i, j));
  }
  int t;
  scanf("%d", &t);
  while (t--) {
    long long n;
    scanf("%I64d", &n);
    if (!go(n)) {
      printf("-1\n");
      continue;
    }
    for (int i = 0; i < 6; i++) {
      print(res[i]);
      res[i].clear();
    }
    printf("\n");
  }
  return 0;
}
