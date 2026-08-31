#include <bits/stdc++.h>
using namespace std;
int nextnum = 1;
int mynum = 0;
int resultnum = 0;
int check[1100] = {0};
int n, x;
int main() {
  int error;
  error = 0;
  cin >> n >> x;
  int input[1100] = {0};
  int count[1100] = {0};
  bool result[2100] = {0};
  void numsearch(int *input, int *check, int x);
  for (int i = 0; i < n; i++) {
    cin >> input[i];
  }
  numsearch(input, check, x - 1);
  int num(int *input, int *check, int i);
  for (int i = 0; i < n; i++) {
    if (check[i] == 0) {
      check[i] = num(input, check, i);
    }
  }
  for (int i = 1; i < nextnum; i++) {
    for (int j = 0; j < n; j++) {
      if (check[j] == i) {
        count[i]++;
      } else {
        error++;
      }
    }
  }
  count[check[x - 1]] = mynum;
  void shukei(int *count, bool *result);
  shukei(count, result);
  for (int i = 1; i < n + 1; i++) {
    if (result[i]) {
      cout << i << endl;
    }
  }
}
int num(int *input, int *check, int i) {
  if (input[i] != 0) {
    int j = input[i];
    return check[i] = num(input, check, j - 1);
  } else {
    if (check[i] != 0) {
      return check[i];
    } else {
      return check[i] = nextnum++;
    }
  }
}
void numsearch(int *input, int *check, int x) {
  if (input[x] == 0) {
    mynum++;
  } else {
    int j = input[x];
    mynum++;
    numsearch(input, check, j - 1);
  }
}
void shukei(int *count, bool *result) {
  result[mynum] = true;
  bool cp[2100];
  for (int j = 1; j < n + 1; j++) {
    cp[j] = result[j];
  }
  for (int i = 1; i < nextnum; i++) {
    if (i != check[x - 1]) {
      for (int j = 1; j < n + 1; j++) {
        if (cp[j]) {
          result[j + count[i]] = true;
        }
      }
      for (int j = 1; j < n + 1; j++) {
        cp[j] = result[j];
      }
    }
  }
}
