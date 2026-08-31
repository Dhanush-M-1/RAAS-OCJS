#include<iostream>
#include<string>
using namespace std;
int main()
{
	int N=0,out=0;
	string ashi1,ashi2;

	while(1)
	{
		cin >> N;
		if(N==0) break;
		for(int i=0;i<N/2;i++)
		{
			cin >> ashi1 >> ashi2;
			if((ashi1=="lu"&&ashi2=="ru")||(ashi1=="ru"&&ashi2=="lu")||(ashi1=="ld"&&ashi2=="rd")||(ashi1=="rd"&&ashi2=="ld")) out++;
		}
		if(N%2==1) cin >> ashi1;
		cout << out << endl;
		out=0;
	}
	return 0;
}