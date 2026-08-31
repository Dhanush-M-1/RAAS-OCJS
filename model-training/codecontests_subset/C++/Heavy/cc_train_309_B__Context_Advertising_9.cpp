#include <bits/stdc++.h>
using namespace std;
string word[1000000];
int words, rows, columns;
int nextRow[30][1000000];
int length[1000001];
int nextRowOf(int pos) {
  int high = words, low = 0;
  while (high > low) {
    int mid = (high + low) / 2;
    int size = length[mid] - length[pos] - 1;
    if (size > columns) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  if (length[high] - length[pos] - 1 > columns) high--;
  return high;
}
int endOfBanner(int pos) {
  int toGo = rows;
  for (int i = 22; i >= 0; i--) {
    if (toGo >= (1 << i)) {
      toGo -= (1 << i);
      pos = nextRow[i][pos];
    }
  }
  return pos;
}
int main() {
  cin >> words >> rows >> columns;
  for (int i = 0; i < words; i++) {
    cin >> word[i];
  }
  for (int i = 1; i <= words; i++) {
    length[i] = length[i - 1] + word[i - 1].size() + 1;
  }
  for (int j = 0; j < words; j++) {
    nextRow[0][j] = nextRowOf(j);
  }
  nextRow[0][words] = words;
  for (int i = 1; i < 22; i++) {
    for (int j = 0; j < words; j++) {
      nextRow[i][j] = nextRow[i - 1][nextRow[i - 1][j]];
    }
    nextRow[i][words] = words;
  }
  int bestScore = -1, bestPos = -1;
  for (int i = 0; i < words; i++) {
    int score = endOfBanner(i) - i;
    if (score > bestScore) {
      bestPos = i;
      bestScore = score;
    }
  }
  for (int i = 0; i < rows; i++) {
    int next = nextRowOf(bestPos);
    if (i != 0 && bestPos != next) cout << "\n";
    for (int j = bestPos; j < next; j++) {
      if (j != bestPos) cout << " ";
      cout << word[j];
    }
    bestPos = next;
  }
}
