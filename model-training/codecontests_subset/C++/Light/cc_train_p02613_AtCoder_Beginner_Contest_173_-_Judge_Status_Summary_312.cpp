#include <iostream>

using namespace std;

int main(){
	int n;
	int a=0,b=0,c=0,d=0;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		string s;
		cin >> s;
		if(s=="AC")a++;
		else if(s=="WA")b++;
		else if(s=="TLE")c++;
		else d++;
	}

	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",a,b,c,d);
}