#include <cstdio>
#include <string>
using namespace std;

int n;

void dfs(string s, char c)
{
	if(s.size() == n)
	{
		puts(s.c_str());
		return;
	}
	for(char i='a'; i<c; i++) dfs(s + i, c);
	dfs(s + c, c + 1);
}

int main(int argc, char** argv)
{
	scanf("%d", &n);
	dfs(string(), 'a');
	return 0;
}