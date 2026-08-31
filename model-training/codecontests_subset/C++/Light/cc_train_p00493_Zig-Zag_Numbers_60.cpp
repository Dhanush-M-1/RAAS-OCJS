/*
    脳みそがないのでJOI予選落ち不可避
 */

#include <stdio.h>
#include <string.h>

#define MOD 10000

enum Dir {UP=0, DOWN, NODIR};
enum Type {LAX=0, SEVERE};
int dp[2][500][10][2][2]; // dp[ind][mod][digit][dir][type]
char a[502];
char b[502];
char nines[502];
int m;
int ans;

int calc(char *digits) {
    int ind, i, i2, j, j2, k;
    int len = strlen(digits);
    int src = 0;
    int dst = 1;
    int ret = 0;

    if (len == 1) return (digits[0]-'0')/m;

    memset(dp, 0, sizeof(dp));

    for (i=1; i<10; i++) {
        int d = digits[0] - '0';

        if (i < d) {
            dp[src][i%m][i][UP][LAX] += 1;
            dp[src][i%m][i][DOWN][LAX] += 1;
        } else if (i == d) {
            dp[src][i%m][i][UP][SEVERE] += 1;
            dp[src][i%m][i][DOWN][SEVERE] += 1;
        }
    }

    for (ind=1; ind<len; ind++) {
        int d = digits[ind] - '0';

        if (ind != 1) {
            for (i=1; i<10; i++) {
                dp[src][i%m][i][UP][LAX] += 1;
                dp[src][i%m][i][DOWN][LAX] += 1;
            }
        }

        for (i=0; i<m; i++) {
            for (j=0; j<10; j++) {
                for (j2=j-1; j2>=0; j2--) {
                    int i2 = (i*10 + j2) % m;

                    dp[dst][i2][j2][DOWN][LAX] += dp[src][i][j][UP][LAX];

                    if (j2 < d) {
                        dp[dst][i2][j2][DOWN][LAX] += dp[src][i][j][UP][SEVERE];
                    } else if (j2 == d) {
                        dp[dst][i2][j2][DOWN][SEVERE] += dp[src][i][j][UP][SEVERE];
                    }

                    dp[dst][i2][j2][DOWN][LAX] %= MOD;
                    dp[dst][i2][j2][DOWN][SEVERE] %= MOD;
                }

                for (j2=j+1; j2<10; j2++) {
                    int i2 = (i*10 + j2) % m;

                    dp[dst][i2][j2][UP][LAX] += dp[src][i][j][DOWN][LAX];

                    if (j2 < d) {
                        dp[dst][i2][j2][UP][LAX] += dp[src][i][j][DOWN][SEVERE];
                    } else if (j2 == d) {
                        dp[dst][i2][j2][UP][SEVERE] += dp[src][i][j][DOWN][SEVERE];
                    }

                    dp[dst][i2][j2][UP][LAX] %= MOD;
                    dp[dst][i2][j2][UP][SEVERE] %= MOD;
                }
            }
        }

        dst ^= 1;
        src ^= 1;
        memset(dp[dst], 0, sizeof(dp[dst]));

    }

    for (i=0; i<2; i++) {
        for (j=0; j<2; j++) {
            for (k=0; k<10; k++) {
                ret += dp[src][0][k][i][j];
                ret %= MOD;
            }
        }
    }

    ret += 9/m;
    return ret;
}

int is_zigzag(char *digits) {
    int i;
    int len = strlen(digits);
    int now = NODIR;
    int pre_d = -1;
    int mod = 0;

    for (i=0; i<len; i++) {
        int d = digits[i] - '0';

        if ((now == UP && d <= pre_d) || (now == DOWN && d >= pre_d)) {
            return 0;
        }

        if (i != 0 && d > pre_d) now = DOWN;
        else if (i != 0 && d < pre_d) now = UP;
        mod = (mod * 10 + d) % m;
        pre_d = d;
    }

    return mod == 0;
}

int main() {
    scanf("%s", a);
    scanf("%s", b);
    scanf("%d", &m);

    ans = calc(b) - calc(a) + is_zigzag(a) + MOD;
    printf("%d\n", ans % MOD);
}