#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  map<int, int> Errors;
  vector<int> Nums(n);
  for (int i = 0; i < n; i++) {
    int num;
    scanf("%d", &num);
    Nums[i] = num;
    Errors[num]++;
  }
  for (int i = 0; i < n - 1; i++) {
    int num;
    scanf("%d", &num);
    Errors[num]--;
  }
  int first = 0;
  for (map<int, int>::iterator it = Errors.begin(); it != Errors.end(); it++) {
    if ((*it).second == 1) {
      first = (*it).first;
      printf("%d\n", (*it).first);
      (*it).second--;
      break;
    }
  }
  bool b = true;
  for (int i = 0; i < n; i++) {
    if (Nums[i] == first && b) {
      b = false;
    } else
      Errors[Nums[i]]++;
  }
  for (int i = 0; i < n - 2; i++) {
    int num;
    scanf("%d", &num);
    Errors[num]--;
  }
  for (map<int, int>::iterator it = Errors.begin(); it != Errors.end(); it++) {
    if ((*it).second == 1) {
      printf("%d", (*it).first);
      break;
    }
  }
  return 0;
}
