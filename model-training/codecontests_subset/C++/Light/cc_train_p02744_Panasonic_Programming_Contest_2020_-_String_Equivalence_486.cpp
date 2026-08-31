#include <algorithm>
#include <cstdio>
using namespace std;
int n;
char s[100];
void dfs(int x, int y) {
    if (x == n) {
        printf("%s\n", s);
        return;
    }
    for (int i = 0; i <= y + 1; i ++) {
        s[x] = i+ 'a';
        dfs(x + 1, max(y, i));
    }
}
int main() {
    scanf("%d", &n);
    dfs(0, -1);
    return 0;
}