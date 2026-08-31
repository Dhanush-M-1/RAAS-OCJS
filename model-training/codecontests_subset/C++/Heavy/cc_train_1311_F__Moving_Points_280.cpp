#include <bits/stdc++.h>
using namespace std;
const int MAX_SIZE = 200010;
pair<int, int> arr[MAX_SIZE], backup[MAX_SIZE];
long long prefix[MAX_SIZE];
int N;
void sortX(int l, int r) {
  if (l >= r) return;
  int mi = (l + r) / 2;
  sortX(l, mi);
  sortX(mi + 1, r);
  int i = l, j = mi + 1, k = l;
  while (i <= mi && j <= r) {
    if (arr[i] < arr[j]) {
      backup[k++] = arr[i++];
    } else {
      backup[k++] = arr[j++];
    }
  }
  while (i <= mi) {
    backup[k++] = arr[i++];
  }
  while (j <= r) {
    backup[k++] = arr[j++];
  }
  for (int i = l; i <= r; i++) {
    arr[i] = backup[i];
  }
}
int lowerBound(int l, int r, int val) {
  while (l <= r) {
    int mi = (l + r) / 2;
    if (arr[mi].second <= val) {
      l = mi + 1;
    } else {
      r = mi - 1;
    }
  }
  int mi = (l + r) / 2;
  if (mi >= l && arr[mi].second > val) return mi - 1;
  return mi;
}
long long mergeSortV(int l, int r) {
  if (l >= r) return 0;
  int mi = (l + r) / 2;
  long long left = mergeSortV(l, mi);
  long long right = mergeSortV(mi + 1, r);
  long long mix = 0LL;
  prefix[l] = 0LL;
  for (int i = l; i <= mi; i++) {
    prefix[i + 1] = prefix[i] + (long long)arr[i].first;
  }
  for (int i = mi + 1; i <= r; i++) {
    int pos = lowerBound(l, mi, arr[i].second);
    long long cnt = pos - l + 1;
    mix += ((long long)arr[i].first * cnt - (prefix[pos + 1] - prefix[l]));
  }
  int i = l, j = mi + 1, k = l;
  while (i <= mi && j <= r) {
    if (arr[i].second < arr[j].second) {
      backup[k++] = arr[i++];
    } else {
      backup[k++] = arr[j++];
    }
  }
  while (i <= mi) {
    backup[k++] = arr[i++];
  }
  while (j <= r) {
    backup[k++] = arr[j++];
  }
  for (i = l; i <= r; i++) {
    arr[i] = backup[i];
  }
  return left + right + mix;
}
long long solveBruteforce() {
  long long sum = 0LL;
  for (int i = 0; i < N; i++) {
    for (int j = i + 1; j < N; j++) {
      if (arr[i].second > arr[j].second) {
        sum += (long long)max(arr[i].first - arr[j].first, 0);
      } else if (arr[i].second < arr[j].second) {
        sum += (long long)max(arr[j].first - arr[i].first, 0);
      } else {
        sum += (long long)max(arr[j].first - arr[i].first,
                              arr[i].first - arr[j].first);
      }
    }
  }
  return sum;
}
int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    int x;
    cin >> x;
    arr[i].first = x;
  }
  for (int i = 0; i < N; i++) {
    int v;
    cin >> v;
    arr[i].second = v;
  }
  sortX(0, N - 1);
  cout << mergeSortV(0, N - 1) << endl;
  return 0;
}
