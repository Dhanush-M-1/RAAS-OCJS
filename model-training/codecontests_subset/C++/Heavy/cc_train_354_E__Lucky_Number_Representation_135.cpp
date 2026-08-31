#include <bits/stdc++.h>
using namespace std;
const long long CARRY = 6;
const long long VALUE = 10;
const long long LOC = 10;
const long long FOURS = 0;
const long long SEVENS = 1;
long long value[50][2] = {0};
bool valid[50] = {0};
long long weight[50] = {0};
long long digis[50] = {0};
bool bad[CARRY][LOC] = {0};
long long digits;
long long number[20] = {0};
long long dig_cnt;
long long answers[6];
long long dfs(long long current_carry, long long loc) {
  if (current_carry == 5)
    while (true) {
    }
  if (bad[current_carry][loc]) {
    return 0;
  }
  if (loc >= dig_cnt) {
    return current_carry == 0;
  }
  long long next_carry, digi;
  next_carry = 0;
  digi = -current_carry;
  digi += number[loc];
  while (digi < 0) {
    digi += 10;
    next_carry++;
  }
  while (digi <= 46) {
    if (!valid[digi]) {
      digi += 10;
      next_carry++;
      continue;
    }
    if (dfs(next_carry, loc + 1)) {
      digis[loc] = digi;
      return 1;
    }
    digi += 10;
    next_carry++;
  }
  bad[current_carry][loc] = 1;
  return 0;
}
void pre_process() {
  for (long long i = 0; i < 7; i++) {
    for (long long j = 0; j < 7; j++) {
      if (i + j > 6) continue;
      value[i * 4 + j * 7][FOURS] = i;
      value[i * 4 + j * 7][SEVENS] = j;
      valid[i * 4 + j * 7] = 1;
    }
  }
  weight[0] = 1;
  for (long long i = 1; i < 19; i++) {
    weight[i] = weight[i - 1] * 10;
  }
}
int main() {
  pre_process();
  long long t_case;
  char buf[100000];
  long long len;
  long long has_sln;
  cin >> t_case;
  for (long long i = 0; i < t_case; i++) {
    memset(bad, 0, sizeof(bad));
    memset(digis, 0, sizeof(digis));
    scanf("%s", buf);
    len = strlen(buf);
    reverse(buf, buf + len);
    for (long long i = 0; i < len; i++) {
      number[i] = buf[i] - '0';
    }
    dig_cnt = len;
    has_sln = dfs(0, 0);
    if (has_sln == 0) {
      puts("-1");
      continue;
    }
    for (long long i = 0; i < 6; i++) {
      answers[i] = 0;
    }
    long long cnt_t[2];
    for (long long i = 0; i < dig_cnt; i++) {
      cnt_t[SEVENS] = value[digis[i]][SEVENS];
      cnt_t[FOURS] = value[digis[i]][FOURS];
      for (long long j = 0; j < 6; j++) {
        if (cnt_t[SEVENS]) {
          cnt_t[SEVENS]--;
          answers[j] += weight[i] * 7LL;
        } else if (cnt_t[FOURS]) {
          cnt_t[FOURS]--;
          answers[j] += weight[i] * 4LL;
        }
      }
    }
    for (long long i = 0; i < 6; i++) {
      cout << answers[i] << " ";
    }
    puts("");
  }
}
