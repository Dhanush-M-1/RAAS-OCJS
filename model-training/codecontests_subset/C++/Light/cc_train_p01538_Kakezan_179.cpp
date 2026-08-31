#include<iostream>
#include<map>
using namespace std;

map<int, int> mem;

int main()
{
  int Q, n;
  cin >> Q;
  for(int q = 0; q < Q; q++)
  {
    mem.clear();
    cin >> n;
    int m = 0;
    while(n >= 10)
    {
      m++;
      mem[n] = 1;
      int tmp = 0;
      for(int j = 10; ; j *= 10)
      {
        int a, b;
        a = n / j;
        b = n % j;
        if(!a)
          break;
        tmp = max(tmp, a * b);
      }
      n = tmp;
      if(mem.count(n))
      {
        cout << -1 << endl; 
        goto end;
      }
    }
    cout << m << endl;
end:;
  }
}