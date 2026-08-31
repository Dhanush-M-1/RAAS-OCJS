#include<stdio.h>
#include<string>
using namespace std;
int N;
void dfs(string s, char mx);
int main(void)
{
	scanf("%d", &N);
	dfs("", 'a');
	return 0;
}
void dfs(string s, char mx)
{
	if (s.length() == N)
		printf("%s\n", s.c_str());
	else
		for (char ch = 'a'; ch <= mx; ch++)
			dfs(s + ch, ch == mx ? mx + 1 : mx);
}