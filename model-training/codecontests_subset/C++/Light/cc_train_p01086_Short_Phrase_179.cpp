#include<cstdio>
#include<cstring>

int n,len[40];
char word[11];

int solve(int pos) {
	int rest;
	rest = 5;
	while (rest > 0) {
		rest -= len[pos++];
		if (rest < 0)return 0;
	}
	rest = 7;
	while (rest > 0) {
		rest -= len[pos++];
		if (rest < 0)return 0;
	}
	rest = 5;
	while (rest > 0) {
		rest -= len[pos++];
		if (rest < 0)return 0;
	}
	rest = 7;
	while (rest > 0) {
		rest -= len[pos++];
		if (rest < 0)return 0;
	}
	rest = 7;
	while (rest > 0) {
			rest -= len[pos++];
			if (rest < 0) return 0;
	}
	return 1;
}

int main() {
	while (1) {
		scanf("%d\n", &n);
		if (n == 0)break;
		for (int i = 0; i < n; i++) {
			scanf("%s\n", word);
			len[i] = strlen(word);
		}
		for (int j = 0; j < n; j++) {
			if (solve(j)) {
				printf("%d\n", j + 1);
				break;
			}
		}
	}
}
