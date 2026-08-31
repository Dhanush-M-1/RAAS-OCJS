#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(void) {
  int N;
  while (cin >> N, N) {
    vector<string> words(N);
    for (int i = 0; i < N; i++) {
      cin >> words[i];
    }

    int tanku_size[] = {5, 7, 5, 7, 7};
    for (int i = 0; i < N; i++) {
      int tanku_pos = 0;
      int letter_size = 0;
      for (int j = i; j < N; j++) {
        letter_size += words[j].size();
        if (letter_size > tanku_size[tanku_pos]) break;
        if (letter_size == tanku_size[tanku_pos]) {
          tanku_pos++;
          letter_size = 0;
        }
      }
      if (tanku_pos == 5) {
        cout << i + 1 << endl;
        break;
      }
    }
  }
  return 0;
}