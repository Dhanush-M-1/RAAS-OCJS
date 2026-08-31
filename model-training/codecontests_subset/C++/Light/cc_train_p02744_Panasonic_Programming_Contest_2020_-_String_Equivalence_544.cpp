#include <bits/stdc++.h>
using namespace std;

int n;
string ans;

void gen(char c)
{
	if(ans.size() == n)
		printf("%s\n", ans.c_str());
	else
	{
		for(char a = 'a'; a <= c; a++)
		{
			ans.push_back(a);
			gen(a == c ? c + 1 : c);
			ans.pop_back();
		}		
	}	
}

int main ()
{
	cin >> n;
	gen('a');
	return 0;
}	