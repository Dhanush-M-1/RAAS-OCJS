#include<bits/stdc++.h>

using namespace std;

int main(void)
{
    int x,k,q;
    vector<int> r;
    vector<int> a,t;

    cin>>x>>k;
    
    for(int i = 0;i < k;i++)
    {
	int temp;
	cin>>temp;
	r.push_back(temp);
    }
    cin>>q;

    for(int i = 0;i < q;i++)
    {
	int ta,tt;

	cin>>tt>>ta;
	t.push_back(tt);
	a.push_back(ta);
    }

    int target = 0;
    int position = 0;
    int ctime = 0;
    int sign = -1;
    int dx = 0;
    int minimum = 0,maximum = x;

    while(position < q)
    {
	if(target == k || t[position] < r[target])
	{
	    int f = max(minimum,min(maximum,a[position]+dx)) + sign*(t[position] - ctime);
	    f = max(0,min(x,f));
	    cout<<f<<endl;
	    position++;
	} else {
	    //Calc variaion
	   int diff = sign*(r[target] - ctime);

	   minimum += diff;
	   maximum += diff;
	   dx += diff;

	   minimum = min(x,minimum);
	   if(minimum < 0)
	       minimum = 0;
	   maximum = min(x,maximum);
	   if(maximum < 0)
	       maximum = 0;

	   sign *= -1;
	   ctime = r[target];
	   target++;
	}

    }
    return 0;
}

