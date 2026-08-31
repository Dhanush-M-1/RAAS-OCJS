#include <bits/stdc++.h>
using namespace std;
int curr;
int A[105];
int S[300];
int L[300];
int M, T;
void ALLOCATE(int n) {
  int start = -1;
  int size = 0;
  for (int i = 0; i < M; i++) {
    if (A[i] > 0) {
      start = -1;
      size = 0;
    } else if (start == -1) {
      start = i;
      size = 1;
    } else {
      size++;
    }
    if (size == n) {
      for (int j = start; j < start + size; j++) A[j] = curr;
      S[curr] = start;
      L[curr] = size;
      cout << curr << "\n";
      curr++;
      return;
    }
  }
  cout << "NULL\n";
}
void ERASE(int x) {
  if (x < 0 || x > 250 || S[x] == -1)
    cout << "ILLEGAL_ERASE_ARGUMENT\n";
  else {
    for (int i = S[x]; i < S[x] + L[x]; i++) A[i] = 0;
    S[x] = -1;
    L[x] = 0;
  }
}
void DEFRAGMENT(void) {
  int first = 0;
  for (int i = 0; i < M; i++) {
    if (A[i] > 0) {
      A[first] = A[i];
      first++;
    }
  }
  for (int i = first; i < M; i++) A[i] = 0;
  int K = -100;
  for (int i = 0; i < M; i++) {
    if (A[i] != K) {
      K = A[i];
      S[K] = i;
    }
  }
}
int main(void) {
  cin >> T >> M;
  curr = 1;
  for (int i = 0; i < M; i++) A[i] = 0;
  for (int i = M; i < 105; i++) A[i] = 1000;
  for (int i = 0; i < 300; i++) {
    S[i] = -1;
    L[i] = 0;
  }
  string S;
  int X;
  for (int i = 0; i < T; i++) {
    cin >> S;
    if (S != "defragment") cin >> X;
    if (S == "defragment") DEFRAGMENT();
    if (S == "alloc") ALLOCATE(X);
    if (S == "erase") ERASE(X);
  }
  return 0;
}
