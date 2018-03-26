# Installing AWS CLI on Mac

To install awscli on mac you need Python 2.6.5 or higher.

Install using pip

```bash
pip install awscli
```

!!! error "You might get the below error during the installation"
    ```error
    Installing collected packages: six, python-dateutil, docutils, botocore, colorama, pyasn1, rsa, futures, s3transfer,    awscli
      Found existing installation: six 1.4.1
        DEPRECATION: Uninstalling a distutils installed project (six) has been deprecated and will be removed in a    future version. This is due to the fact that uninstalling a distutils project will only partially uninstall the   project.
        Uninstalling six-1.4.1:
    Exception:
    Traceback (most recent call last):
      File "/Library/Python/2.7/site-packages/pip/basecommand.py", line 215, in main
        status = self.run(options, args)
      File "/Library/Python/2.7/site-packages/pip/commands/install.py", line 342, in run
        prefix=options.prefix_path,
      File "/Library/Python/2.7/site-packages/pip/req/req_set.py", line 778, in install
        requirement.uninstall(auto_confirm=True)
      File "/Library/Python/2.7/site-packages/pip/req/req_install.py", line 754, in uninstall
        paths_to_remove.remove(auto_confirm)
      File "/Library/Python/2.7/site-packages/pip/req/req_uninstall.py", line 115, in remove
        renames(path, new_path)
      File "/Library/Python/2.7/site-packages/pip/utils/__init__.py", line 267, in renames
        shutil.move(old, new)
      File "/System/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/shutil.py", line 302, in move
        copy2(src, real_dst)
      File "/System/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/shutil.py", line 131, in copy2
        copystat(src, dst)
      File "/System/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/shutil.py", line 103, in copystat
        os.chflags(dst, st.st_flags)
    OSError: [Errno 1] Operation not permitted:     '/var/folders/p5/qvcpp48j55z1zqsggck_v1280000gn/T/pip-zghy0c-uninstall/System/Library/Frameworks/Python.    framework/Versions/2.7/Extras/lib/python/six-1.4.1-py2.7.egg-info'
    ```

!!! success "Solution"
    ```bash
    sudo -H pip install awscli --upgrade --ignore-installed six
    ```